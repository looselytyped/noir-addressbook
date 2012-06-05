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
            (label "lastname" "Last Name")
            (text-field "lastname" (:lastname entry))
            (label "phone" "Phone")
            (text-field "phone" (:phone entry))
            (submit-button "Add Friend"))))

(defpage [:post "/"] {:as entry}
  (render "/" entry))