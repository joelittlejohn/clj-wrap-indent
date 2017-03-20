(ns clj-wrap-indent.core-test
  (:require [clojure.test :refer :all]
            [clj-wrap-indent.core :as wrap]))

(deftest wrap-and-indent-single-line
  (is (= (str "       Strings are objects (as opposed to sequences). As such, the string being\n"
              "       manipulated is the first argument to a function; passing nil will result\n"
              "       in a NullPointerException unless documented otherwise. If you want\n"
              "       sequence-y behavior instead, use a sequence.")
         (wrap/wrap-indent "Strings are objects (as opposed to sequences). As such, the string being manipulated is the first argument to a function; passing nil will result in a NullPointerException unless documented otherwise. If you want sequence-y behavior instead, use a sequence."))))

(deftest wrap-and-indent-custom-layout
  (is (= (str"  Strings are objects (as opposed to sequences). As such, the string being manipulated is the first argument to a\n"
             "  function; passing nil will result in a NullPointerException unless documented otherwise. If you want sequence-y\n"
             "  behavior instead, use a sequence.")
         (wrap/wrap-indent "Strings are objects (as opposed to sequences). As such, the string being manipulated is the first argument to a function; passing nil will result in a NullPointerException unless documented otherwise. If you want sequence-y behavior instead, use a sequence." 120 2))))

(deftest wrap-and-indent-multi-line
  (is (= (str "       Strings are objects (as opposed to sequences).\n"
              "       As such, the string being manipulated is the first argument to a\n"
              "       function; passing nil will result in a NullPointerException unless\n"
              "       documented otherwise.\n"
              "       If you want sequence-y behavior instead, use a sequence.")
         (wrap/wrap-indent "Strings are objects (as opposed to sequences).\nAs such, the string being manipulated is the first argument to a function; passing nil will result in a NullPointerException unless documented otherwise.\nIf you want sequence-y behavior instead, use a sequence."))))

(deftest wrap-and-indent-empty-inputs
  (is (= "" (wrap/wrap-indent "")))
  (is (= nil (wrap/wrap-indent nil))))

(deftest println-wraps-and-prints
  (let [output (with-out-str (wrap/println "Strings are objects (as opposed to sequences). As such, the string being manipulated is the first argument to a function; passing nil will result in a NullPointerException unless documented otherwise. If you want sequence-y behavior instead, use a sequence."))]
    (is (= (str "       Strings are objects (as opposed to sequences). As such, the string being\n"
                "       manipulated is the first argument to a function; passing nil will result\n"
                "       in a NullPointerException unless documented otherwise. If you want\n"
                "       sequence-y behavior instead, use a sequence.\n")
           output))))
