(ns app.ui
  (:require
   [com.fulcrologic.fulcro.components :as compo :refer [defsc]]
   [com.fulcrologic.fulcro.dom :as dom]
   [app.mutations :as api]))

(defsc Counter [_ {:counter/keys [id count]} {:keys [onInc]}]
  {:ident :counter/id
   :query [:counter/id :counter/count]
   :initial-state {:counter/id :param/id
                   :counter/count :param/count}}
  (dom/p (str "You have clicked " count " times   ")
         (dom/button {:onClick #(onInc id)} "Click Me!")))
(def ui-counter (compo/factory Counter))

(defsc Root [this {:root/keys [counter]}]
  {:query [{:root/counter (compo/get-query Counter)}]
   :initial-state {:root/counter {:id 1 :count 0}}}
  (let [inc-count (fn [counter-id] (compo/transact! this [(api/inc-count {:counter/id counter-id})]))]
    (dom/div
     (ui-counter (compo/computed counter {:onInc inc-count})))))

(comment (compo/get-query Root))
(comment (compo/get-initial-state Counter {:id 2 :count 55}))