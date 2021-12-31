(ns app.mutations
  (:require
   [com.fulcrologic.fulcro.mutations :refer [defmutation]]))

(defmutation inc-count [{:counter/keys [id]}]
  (action [{:keys [state]}]
          (swap! state update-in [:counter/id id :counter/count] inc)))