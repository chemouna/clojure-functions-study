(ns letfn)

(defn compartr
  [s1 s2]
  (letfn [ (inner-author [author] ((juxt :lname :fname) author)) ]
    (compare (inner-author s1) (inner-author s2)) ))

(sorted-set-by compartr
               {:fname "Steve" :lname "Smith"}
               {:fname "David" :lname "Smith"})
