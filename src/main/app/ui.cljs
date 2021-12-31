(ns app.ui
  (:require
   [com.fulcrologic.fulcro.components :as compo :refer [defsc]]
   [com.fulcrologic.fulcro.dom :as dom]
   [components.counter :as counter]))


(defsc Root [_  {:root/keys [counter]}]
  {:query [{:root/counter (compo/get-query counter/Counter)}]
   :initial-state {:root/counter {:id 1 :count 0}}}
  (dom/div
   (counter/ui-counter counter)))