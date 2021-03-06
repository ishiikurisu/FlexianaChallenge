(ns challenge.core-test
  (:require [clojure.test :refer :all]
            [challenge.lib :refer :all]))

; unit tests
(deftest verify-testing-regular-cases
    (testing "Regular test cases for scramble function"
        (is (scramble? "rekqodlw" "world"))
        (is (scramble? "cedewaraaossoqqyt" "codewars"))
        (is (not (scramble? "katas" "steak")))
        (is (scramble? "asdf" "as"))
        (is (not (scramble? "qwerty" "as")))
        (is (scramble? "aaaa" "a"))
        (is (not (scramble? "a" "aaaa")))))
