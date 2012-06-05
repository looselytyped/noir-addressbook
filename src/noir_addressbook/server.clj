(ns noir-addressbook.server
  (:require [noir.server :as server]))

(server/load-views "src/noir_addressbook/views/")

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "8080"))]
    (server/start port {:mode mode
                        :ns 'noir-addressbook})))

