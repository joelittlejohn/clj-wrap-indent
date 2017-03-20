(ns clj-wrap-indent.core
  (:import org.apache.commons.lang3.text.WordUtils)
  (:refer-clojure :exclude [println])
  (:require [clojure.string :as str]))

(defn wrap-indent
  "Wrap and indent a paragraph of text to a given column limit (default
  80) and indent (default 7). The text may be a single line or multiple
  lines separated by \\n chars."
  ([text]
   (wrap-indent text 80))
  ([text cols]
   (wrap-indent text cols 7))
  ([^String text ^Integer cols ^Integer indent]
   (if text
     (let [indent-string (apply str (repeat indent " "))]
       (->> text
            str/split-lines
            (map #(WordUtils/wrap % (- cols indent) nil true))
            (map #(str/replace % #"(?m)^" indent-string))
            (str/join "\n"))))))

(defn println
  "Wraps, indents and prints. See wrap-indent."
  [& args]
  (clojure.core/println (apply wrap-indent args)))
