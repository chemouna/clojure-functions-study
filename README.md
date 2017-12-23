# clojure-functions-study

### letfn
```
fnspec ==> (fname [params*] exprs) or (fname ([params*] exprs)+)
Takes a vector of function specs and a body, and generates a set of bindings of functions to their names. 
All of the names are available in all of the definitions of the functions, as well as the body.
```

#### Examples 
```clojure
(defn compartr [s1 s2]
  (letfn [ (inner-author [author] ((juxt :lname :fname) author))] 
    (compare (inner-author s1) (inner-author s2))))
=> #'user/compartr

(sorted-set-by compartr
               {:fname "Steve" :lname "Smith"}
               {:fname "David" :lname "Smith"})

=> #{{:fname "David", :lname "Smith"} {:fname "Steve", :lname "Smith"}}
```

### juxt

## License

Copyright © 2017 Mouna Cheikhna

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
