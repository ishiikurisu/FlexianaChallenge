(ns app
    (:require [goog.dom :as dom]
              [goog.events :as events]
              [ajax.core :refer [GET]]))

(defn get-field [field-id]
    (.. (dom/getElement field-id) -value))

(defn on-click [event]
    (let [str1 (get-field "str1")
          str2 (get-field "str2")
          url (str "/api/scramble?str1=" str1 "&str2=" str)
          result (GET url)]
        (js/console.log result))
)

(events/listen
    (dom/getElement "scramble-button")
    "click"
    on-click
)
