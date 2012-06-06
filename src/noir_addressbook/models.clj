(ns noir-addressbook.models
  (:use somnium.congomongo))

(defn init-mongodb
  []
  (mongo! :db "addressbook"))