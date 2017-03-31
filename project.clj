(defproject html-diff "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [tempfile "0.2.0"]
                 [hickory "0.7.0"]
                 [fipp "0.6.8"]
                 [gui-diff "0.6.7"]]
  :main ^:skip-aot html-diff.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
