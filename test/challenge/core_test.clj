(ns challenge.core-test
  (:require [clojure.test :refer :all]
            [challenge.core :refer :all]))

(deftest verify-testing-regular-cases
    (testing "FIXME, I fail."
        (is (scramble? "rekqodlw" "world"))
        (is (scramble? "cedewaraaossoqqyt" "codewars"))
        (is (not (scramble? "katas" "steak")))))
