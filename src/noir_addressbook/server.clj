(ns noir-addressbook.server
  (:require [noir.server :as server]))

(server/load-views "src/noir_addressbook/views/")

(defn start-server
  ([] (start-server 8080))
  ([port] (start-server port {:mode :dev}))
  ([port opts] (server/start port (assoc opts :ns 'noir-addressbook))))

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (start-server port {:mode mode
                        :ns 'noir-addressbook})))

