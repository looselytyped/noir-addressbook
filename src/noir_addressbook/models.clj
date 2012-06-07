(ns noir-addressbook.models
  (:use somnium.congomongo
        [somnium.congomongo.config :only [*mongo-config*]]))

(defn split-mongo-url [url]
  (let [matcher (re-matcher #"^.*://(.*?):(.*?)@(.*?):(\d+)/(.*)$" url)]
    (when (.find matcher)
      (zipmap [:match :user :pass :host :port :db] (re-groups matcher)))))

(defn init-mongodb []
  (when (not (connection? *mongo-config*))
    (if-let [mongo-url (get (System/getenv) "MONGOHQ_URL")]
      (let [config (split-mongo-url mongo-url)]
        (println "Initializing mongo @ " mongo-url)
        (mongo! :db (:db config)
                :host (:host config)
                :port (Integer. (:port config)))
        (authenticate (:user config) (:pass config))
        (or (collection-exists? :addressbook)
            (create-collection! :addressbook)))
      (mongo! :db "addressbook") ; local environment
      )))

