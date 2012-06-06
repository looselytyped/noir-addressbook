(ns noir-addressbook.models.entry
  (:use somnium.congomongo)
  (:require [noir.validation :as validate]))

(defn valid? [{:keys [firstname lastname]}]
  (validate/rule (validate/has-value? firstname)
                 [:firstname "is required"])
  (validate/rule (validate/min-length? firstname 4)
                 [:firstname "Must be at least 4 characters"])
  (validate/rule (validate/has-value? lastname)
                 [:lastname "is required"])
  (validate/rule (validate/min-length? lastname 4)
                 [:lastname "Must be at least 4 characters"])
  (not (validate/errors? :firstname :lastname)))

(defn add!
  [entry]
  (when (valid? entry) (insert! :addressbook entry)))