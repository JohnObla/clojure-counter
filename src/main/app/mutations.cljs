(ns app.mutations
  (:require
   [com.fulcrologic.fulcro.mutations :refer [defmutation]]))

(defmutation inc-count
  "Increment count by one"
  [{id :counter/id}]
  (action [{:keys [state]}]
          (swap! state update-in [:counter/id id :counter/count] inc)))

(comment (def some-map {:counters {1 {:counter/id 1
                                      :counter/count 0}}}))

(comment (update-in some-map [:counters 1 :counter/count] inc))

(comment (:counters some-map))