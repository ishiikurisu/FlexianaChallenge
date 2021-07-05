(ns challenge.lib
  (:gen-class)
  (:require [clojure.set :refer :all]))

(defn scramble? [str1 str2]
    (superset? (set str1) (set str2)))
