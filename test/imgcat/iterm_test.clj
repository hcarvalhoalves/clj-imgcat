(ns imgcat.iterm-test
  (:require [midje.sweet :refer :all]
            [clojure.java.io]
            [imgcat.iterm :refer :all]))


(def sample-file (delay (clojure.java.io/as-file (clojure.java.io/resource "travolta.gif"))))

(facts "on read-file-as-bytes"
       (fact "can read file and return bytearray"
             (alength (read-file-as-bytes @sample-file))
             => 3863916))

(defn base64bytes->chars [n] (/ (* 4 n) 3))

(facts "on bytes->iterm2-blob"
       (fact
         (-> @sample-file
             read-file-as-bytes
             bytes->iterm2-blob
             count
             (> (base64bytes->chars 3863916)))
         => true))

(cat! (sample->iterm2-blob "travolta.gif"))