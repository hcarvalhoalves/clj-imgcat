(ns imgcat.core
  (:require [imgcat.iterm :as iterm]))

(defrecord ReifiedImgcat [file]
  Object
  (toString [this]
    (cond (iterm/is-iterm?)
          (iterm/file->iterm2-blob file)
          :else
          (pr-str this))))

(defn from-file [file]
  (ReifiedImgcat. file))