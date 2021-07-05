(ns challenge.core
  (:gen-class)
  (:require [clojure.set :refer :all]
            [clojure.data.json :as json]
            [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]))

; scramble function
(defn scramble? [str1 str2]
    (superset? (set str1) (set str2)))

; Routes
(defn get-params [req param]
    (get [:params req] param))

(defn index-page [req]
    {:status 200
     :headers {"Content-Type" "text/html"}
     :body "Welcome!"})

(defn scramble-api [req]
    {:status 200
     :headers {"Content-Type" "text/json"}
     :body (str (json/write-str (scramble? (get-params req "req1")
                                           (get-params req "req2"))))})

(defroutes app-routes
    (GET "/" [] index-page)
    (GET "/api/scramble" [] scramble-api))

; Entry point
(defn -main [& args]
    (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
        (server/run-server (wrap-defaults #'app-routes site-defaults) {:port port})
        (println (str "Listening at http://localhost:" port "/"))))
