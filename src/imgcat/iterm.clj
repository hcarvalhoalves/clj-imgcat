(ns imgcat.iterm
  (:require [clojure.java.io :as jio])
  (:import (java.util Base64)
           (java.io File FileInputStream ByteArrayOutputStream)))

(defn read-file-as-bytes [^File f]
  (let [ary (byte-array (.length f))
        is  (FileInputStream. f)]
    (.read is ary)
    (.close is)
    ary))

(def iterm2-protocol-tmpl
  "Implements https://www.iterm2.com/documentation-images.html"
  (str "\033]1337;"
       "File="
       "size=%s;"
       "inline=1"
       ":%s"
       (char 7)))

(defn bytes->iterm2-blob [bytes]
  (let [encoder (Base64/getEncoder)]
    (format iterm2-protocol-tmpl (alength bytes) (.encodeToString encoder bytes))))

(def sample->iterm2-blob (comp bytes->iterm2-blob read-file-as-bytes jio/as-file jio/resource))

(defn supported-terminal? []
  (= (System/getenv "TERM_PROGRAM") "iTerm.app"))

(defn cat! [^String blob]
  (when (supported-terminal?)
    (println blob)))