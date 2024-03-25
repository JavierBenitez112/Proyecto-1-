(defun farenheit-to-celsius (f)
  (* (/ (- f 32) 9) 5))


  

(format t "La temperatura en celsius es: ~A" (farenheit-to-celsius 32))
