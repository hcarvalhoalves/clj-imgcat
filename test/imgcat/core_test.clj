(ns imgcat.core-test
  (:require [clojure.test :refer :all]
            [imgcat.core :refer :all]))

;; Test reified image object
(println (str (from-file "resources/travolta.gif")))

;; Test data reader
(println (str #imgcat/file "resources/travolta.gif"))