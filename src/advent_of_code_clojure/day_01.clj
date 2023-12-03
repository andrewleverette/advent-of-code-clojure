(ns advent-of-code-clojure.day-01
  (:require [clojure.string :as str]))

(def digit-pattern #"\d")
(def number-pattern #"(?=(\d|one|two|three|four|five|six|seven|eight|nine))")

(def digit-lookup
  {"one" "1"
   "two" "2"
   "three" "3"
   "four" "4"
   "five" "5"
   "six" "6"
   "seven" "7"
   "eight" "8"
   "nine" "9"})

(defn- parse-input
  [f input]
  (->> input
       str/split-lines
       (map f)))

(defn parse-digit-input
  [input]
  (parse-input #(re-seq digit-pattern %) input))

(defn parse-numeric-input
  [input]
  (parse-input #(map second (re-seq number-pattern %)) input))

(defn line->calibration-value
  [line]
  (let [numbers (map #(get digit-lookup % %) line)
        num (str (first numbers) (last numbers))]
    (try
      (Integer/parseInt num)
      (catch Exception e
        (println "Could not parse number: "
                 num
                 "\nError: " (.getMessage e))
        0))))

(defn calibration-checksum
  [lines]
  (->> lines
       (map line->calibration-value)
       (reduce +)))

(defn part-1
  [input]
  (->> input
       parse-digit-input
       calibration-checksum))

(defn part-2
  [input]
  (->> input
       parse-numeric-input
       calibration-checksum))
