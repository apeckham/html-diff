(ns html-diff.core
  (:gen-class)
  (:require [hickory.core :as hickory]
            [clojure.java.shell :refer [sh]]
            [fipp.edn :as fipp]
            [tempfile.core :refer [tempdir with-tempfile]]))

(defn parse [url]
  (println (str "Fetching " url))
  (-> url slurp hickory/parse hickory/as-hiccup))

(defn diff [text1 text2]
  (with-tempfile [dir (tempdir)]
    (spit (str dir "1") (with-out-str (fipp/pprint text1)))
    (spit (str dir "2") (with-out-str (fipp/pprint text2)))
    (future (sh "opendiff" (str dir "1") (str dir "2")))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [[url1 url2] args]
    (diff (parse url1) (parse url2)))
  (shutdown-agents))
