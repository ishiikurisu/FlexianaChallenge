(ns challenge.core
  (:gen-class)
  (:require [challenge.lib :refer :all]
            [clojure.data.json :as json]
            [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [selmer.parser :refer :all]))

; Routes
(defn get-params [req param]
    (param (:params req)))

(defn index-page [req]
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body (render-file "html/index.html" {})})

(defn scramble-api [req]
    {:status 200
     :headers {"Content-Type" "text/json"}
     :body (str (json/write-str (scramble? (get-params req :str1)
                                           (get-params req :str2))))})

(defroutes app-routes
    (GET "/" [] index-page)
    (GET "/api/scramble" [] scramble-api))

; Entry point
(defn -main [& args]
    (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
        (server/run-server (wrap-defaults #'app-routes site-defaults) {:port port})
        (println (str "Listening at http://localhost:" port "/"))))
