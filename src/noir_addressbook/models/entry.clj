(ns noir-addressbook.models.entry
  (:use somnium.congomongo))

(defn add!
  [entry]
  (insert! :addressbook entry))