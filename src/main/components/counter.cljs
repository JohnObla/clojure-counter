(ns components.counter
  (:require
   [com.fulcrologic.fulcro.components :as compo :refer [defsc]]
   [com.fulcrologic.fulcro.dom :as dom]
   [app.mutations :as api]))

(defsc Counter [this {:counter/keys [id count]}]
  {:ident :counter/id
   :query [:counter/id :counter/count]
   :initial-state {:counter/id :param/id
                   :counter/count :param/count}}

  (let [inc-count #(compo/transact! this [(api/inc-count {:counter/id id})])]
    (dom/p (str "You have clicked " count " times   ")
           (dom/button {:onClick inc-count} "Click Me!"))))

(def ui-counter (compo/factory Counter))