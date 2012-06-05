(ns noir-addressbook.views.home
  (:use noir.core
        hiccup.core
        hiccup.form)
  (:require [noir-addressbook.views.common :as common]))

(defpage "/" {:as entry}
  (common/layout
   (form-to [:post "/"]
            (label "firstname" "First Name")
            (text-field "firstname" (:firstname entry))
            (submit-button "Add Friend"))))