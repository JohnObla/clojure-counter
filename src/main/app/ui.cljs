(ns app.ui
  (:require
   [com.fulcrologic.fulcro.components :as compo :refer [defsc]]
   [com.fulcrologic.fulcro.dom :as dom]))

(defsc Counter [_ {:counter/keys [count]}]
  {:query [:counter/id :counter/count]
   :ident :counter/id
   :initial-state (fn [{:keys [id count]}] {:counter/id id :counter/count count})}
  (dom/p (str "You have clicked " count " times")
         (dom/button "Click Me!")))

(def ui-counter (compo/factory Counter))

(defsc Root [_ {:keys [counter]}]
  {:query [{:counter (compo/get-query Counter)}]
   :initial-state (fn [_] {:counter (compo/get-initial-state Counter {:id 1 :count 0})})}
  (dom/div (ui-counter counter)))
