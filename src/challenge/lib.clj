(ns challenge.lib
  (:gen-class))

(defn verify-scramble [s1 s2]
    (every? (fn [count]
                (let [k (key count)
                      v1 (get s1 k 0)
                      v2 (get s2 k)]
                    (>= v1 v2)))
            s2))

(defn scramble? [str1 str2]
    (verify-scramble (frequencies str1) (frequencies str2)))
