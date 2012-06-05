(ns noir-addressbook.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "noir-addressbook"]
               (include-css "/css/reset.css")]
              [:body
               [:div#wrapper
                content]]))
