(ns noir-addressbook.views.home
  (:use noir.core
        hiccup.core
        hiccup.form)
  (:require [noir-addressbook.views.common :as common]
            [noir-addressbook.models.entry :as entry]
            [noir.response :as resp]
            [noir.validation :as validate]))

(defpartial error-item [[first-error]]
  [:p.error first-error])

(defpage "/" {:as entry}
  (common/layout
   (form-to [:post "/"]
            (validate/on-error :firstname error-item)
            (label "firstname" "First Name")
            (text-field "firstname" (:firstname entry))
            (validate/on-error :lastname error-item)
            (label "lastname" "Last Name")
            (text-field "lastname" (:lastname entry))
            (label "phone" "Phone")
            (text-field "phone" (:phone entry))
            (submit-button "Add Friend"))))

(defpage [:post "/"] {:as entry}
  (if (entry/add! entry)
    (resp/redirect "/")
    (render "/" entry)))

