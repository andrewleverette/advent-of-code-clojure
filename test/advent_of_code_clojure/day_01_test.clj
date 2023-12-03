(ns advent-of-code-clojure.day-01-test
  (:require
   [clojure.test :refer [deftest is]]
   [advent-of-code-clojure.day-01 :as day01]))

(deftest parse-digit-input-test
  (is (= [["1" "2"]] (day01/parse-digit-input "1abc2")))
  (is (= [["3" "8"]] (day01/parse-digit-input "pqr3stu8vwx")))
  (is (= [["1" "2" "3" "4" "5"]] (day01/parse-digit-input "a1b2c3d4e5f")))
  (is (= [["7"]] (day01/parse-digit-input "pqr7"))))

(deftest parse-numeric-input-test
  (is (= [["one" "2" "three"]] (day01/parse-numeric-input "one2three")))
  (is (= [["2" "nine"]] (day01/parse-numeric-input "2nine")))
  (is (= [["eight" "two" "three"]] (day01/parse-numeric-input "eighttwothree")))
  (is (= [["4" "nine" "eight" "seven" "2"]] (day01/parse-numeric-input "4nineeightseven2")))
  (is (= [["7" "six"]] (day01/parse-numeric-input "7pqrstsixteen"))))

(deftest line-calibration-for-digits-only
  (is (= 11 (day01/line->calibration-value ["1"])))
  (is (= 11 (day01/line->calibration-value ["1" "1"])))
  (is (= 12 (day01/line->calibration-value ["1" "2"])))
  (is (= 38 (day01/line->calibration-value ["3" "8"])))
  (is (= 15 (day01/line->calibration-value ["1" "2" "3" "4" "5"])))
  (is (= 77 (day01/line->calibration-value ["7"])))
  (is (= 13 (day01/line->calibration-value ["one" "2" "three"])))
  (is (= 29 (day01/line->calibration-value ["2" "nine"])))
  (is (= 83 (day01/line->calibration-value ["eight" "two" "three"])))
  (is (= 76 (day01/line->calibration-value ["7" "six"]))))

(deftest calibration-checksum
  (is (= 12 (day01/calibration-checksum [["1" "2"]])))
  (is (= 50 (day01/calibration-checksum [["1" "2"] ["3" "8"]])))
  (is (= 65 (day01/calibration-checksum [["1" "2"] ["3" "8"] ["1" "2" "3" "4" "5"]])))
  (is (= 142 (day01/calibration-checksum [["1" "2"] ["3" "8"] ["1" "2" "3" "4" "5"] ["7"]]))))
