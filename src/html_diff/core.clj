(ns html-diff.core
  (:gen-class)
  (:require [hickory.core :as hickory]
            [gui.diff :refer [gui-diff-data]]))

(defn parse [url]
  (println (str "Fetching " url))
  (-> url slurp hickory/parse hickory/as-hiccup))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [[url1 url2] args]
    (gui-diff-data (parse url1) (parse url2))))


