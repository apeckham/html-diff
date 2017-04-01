(ns html-diff.core
  (:gen-class)
  (:require [hickory.core :as hickory]
            [clojure.java.shell :refer [sh]]
            [clojure.string :refer [replace]]
            [fipp.edn :as fipp]
            [tempfile.core :refer [tempdir with-tempfile]]))

(defn parse [url]
  (println (str "Fetching " url))
  (-> url slurp hickory/parse hickory/as-hiccup))

(defn spit-hiccup [path text]
  (spit path (replace (with-out-str (fipp/pprint text)) #" +\"\\n\"\n" "")))

(defn diff [text1 text2]
  (with-tempfile [dir (tempdir)]
    (let [file1 (str dir "1")
          file2 (str dir "2")]
      (spit-hiccup file1 text1)
      (spit-hiccup file2 text2)
      (future (sh "opendiff" file1 file2)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [[url1 url2] args]
    (diff (parse url1) (parse url2)))
  (shutdown-agents))
