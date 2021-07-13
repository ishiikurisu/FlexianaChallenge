(ns challenge.core-test
  (:require [clojure.test :refer :all]
            [challenge.lib :refer :all]))

; unit tests
(deftest verify-testing-regular-cases
    (testing "Regular test cases for scramble function"
        (is (true? (scramble? "rekqodlw" "world")))
        (is (true? (scramble? "cedewaraaossoqqyt" "codewars")))
        (is (false? (scramble? "katas" "steak")))
        (is (true? (scramble? "asdf" "as")))
        (is (false? (scramble? "qwerty" "as")))
        (is (true? (scramble? "aaaa" "a")))
        (is (false? (scramble? "a" "aaaa")))))
