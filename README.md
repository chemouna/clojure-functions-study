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

```clojure
(defn pow [base exp]
  (letfn [(kapow [base exp acc]
            (if (zero? exp)
              acc
              (recur base (dec exp) (* base acc))))]
    (kapow base exp 1)))

(pow 2 50)
```

- letfn is very similar to the let form, with this difference, that declared symbols are available everywhere 
inside the function the letfn is declared in  (not only inside the letfn square brackets like with let) and 
it's used only for functions. 

- if you need mutual recursion(mutual recursion is a form of recursion where two functions or data types, are defined 
in terms of each other) through your local functions, you'll have to letfn them either way.
example :
```clojure
(defn ring [n]
  (letfn [(a [n] (if (zero? n) n (b (dec n))))
          (b [n] (if (zero? n) n (c (dec n))))
          (c [n] (if (zero? n) n (a (dec n))))]
    (c n)))

(ring 1000)
```


### juxt

## License

Copyright © 2017 Mouna Cheikhna

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
