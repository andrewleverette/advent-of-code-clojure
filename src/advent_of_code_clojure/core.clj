(ns advent-of-code-clojure.core
  (:require
   [clojure.java.io :as io]
   [advent-of-code-clojure.day-01 :as day01]))

(defn read-input
  [day]
  (slurp (io/resource day)))

(defn -main
  [args]
  (case args
    "d01.p1" (println (day01/part-1 (read-input "day-01.txt")))
    "d01.p2" (println (day01/part-2 (read-input "day-01.txt")))
    (println "not found")))
