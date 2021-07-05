(ns app
    (:require [goog.dom :as dom]
              [goog.events :as events]
              [ajax.core :refer [GET]]))

(defn is-valid [input-fields]
    (every? true?
            (map #(= %1 (re-matches #"[a-z]*" %1))
                 input-fields)))

(defn get-field [field-id]
    (.. (dom/getElement field-id) -value))

(defn set-field [field-id inner-html]
    (-> js/document
        (.getElementById field-id)
        (.-innerHTML)
        (set! inner-html)))

(defn on-click-handler [result]
    (set-field "scramble-result" (if result "Yes!" "No!")))

(defn on-click-error-handler [error]
    (js/console.log error))

(defn on-click [event]
    (let [str1 (get-field "str1")
          str2 (get-field "str2")]
        (if (is-valid [str1 str2])
            (GET "/api/scramble" {:params {:str1 str1
                                           :str2 str2}
                                  :handler on-click-handler
                                  :error-handler on-click-error-handler
                                  :response-format :json})
            (js/alert "Invalid input"))))

(events/listen (dom/getElement "scramble-button") "click" on-click)
