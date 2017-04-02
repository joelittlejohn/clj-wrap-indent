# clj-wrap-indent [![Build Status](https://travis-ci.org/joelittlejohn/clj-wrap-indent.png)](https://travis-ci.org/joelittlejohn/clj-wrap-indent)

[![clj-wrap-indent at Clojars](https://clojars.org/clj-wrap-indent/latest-version.svg)](https://clojars.org/clj-wrap-indent)

A Clojure library to wrap, indent and (if required) print paragraphs. Useful for neat docs in the console.

Supports single- or multi-line text as input.

## Usage

```clj
(ns myapp.core
  (require [clj-wrap-indent.core :as wrap]))
    
;; get a wrapped and indented string
(wrap/wrap-indent "Some text...")
(wrap/wrap-indent "Some text..." 80)
(wrap/wrap-indent "Some text..." 80 7)

;; print a wrapped and indented string to stdout
(wrap/println "Some text...")
(wrap/println "Some text..." 80)
(wrap/println "Some text..." 80 7)
```
```
;; example println

user=> (wrap/println "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
       Lorem Ipsum is simply dummy text of the printing and typesetting
       industry. Lorem Ipsum has been the industry's standard dummy text ever
       since the 1500s, when an unknown printer took a galley of type and
       scrambled it to make a type specimen book.

user=> (wrap/println "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book." 
                     40 2)
  Lorem Ipsum is simply dummy text of
  the printing and typesetting industry.
  Lorem Ipsum has been the industry's
  standard dummy text ever since the
  1500s, when an unknown printer took a
  galley of type and scrambled it to
  make a type specimen book.
```

## License

Copyright © 2017 Joe Littlejohn

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
