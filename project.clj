(defproject clj-wrap-indent "1.0.0"
  :description "Wrap and indent a paragraph of text. Good for help docs that are a bit like man pages."
  :url "http://github.com/joelittlejohn/clj-wrap-indent"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :global-vars {*warn-on-reflection* true}
  :dependencies [[org.apache.commons/commons-lang3 "3.5"]]
  :deploy-repositories [["releases" :clojars]]
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.8.0"]]}})
