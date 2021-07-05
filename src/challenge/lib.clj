(ns challenge.lib
  (:gen-class)
  (:require [clojure.set :refer :all]))

(defn count-letters [s]
    (reduce (fn [collection item]
                (assoc collection
                       item
                       (if (contains? collection item)
                           (+ 1 (get collection item))
                           1)))
            {}
            s))

(defn verify-scramble [s1 s2]
    (every? identity
            (map (fn [count]
                     (let [k (key count)
                           v1 (or (get s1 k) 0)
                           v2 (get s2 k)]
                         (>= v1 v2)))
                 s2)))

(defn scramble? [str1 str2]
    (verify-scramble (count-letters str1) (count-letters str2)))
