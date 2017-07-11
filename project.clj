(defproject imgcat "0.1.0-SNAPSHOT"
  :description "Blit images onto supported Terminals."
  :url "github.com/hcarvalhoalves/clj-imgcat"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :resource-paths ["resources"]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [midje "1.8.3"]]
  :plugins [[lein-midje "3.1.3"]]
  :test-paths ["test/"])
