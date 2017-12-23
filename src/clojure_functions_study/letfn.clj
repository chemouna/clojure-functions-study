(ns letfn)

; Example 1
(defn compartr
  [s1 s2]
  (letfn [ (inner-author [author] ((juxt :lname :fname) author)) ]
    (compare (inner-author s1) (inner-author s2)) ))

(sorted-set-by compartr
               {:fname "Steve" :lname "Smith"}
               {:fname "David" :lname "Smith"})

;; Example 2
(defn pow [base exp]
  (letfn [(kapow [base exp acc]
            (if (zero? exp)
              acc
              (recur base (dec exp) (* base acc))))]
    (kapow base exp 1)))

(pow 2 50)


(defn ring [n]
  (letfn [(a [n] (if (zero? n) n (b (dec n))))
          (b [n] (if (zero? n) n (c (dec n))))
          (c [n] (if (zero? n) n (a (dec n))))]
    (c n)))

(ring 1000)


