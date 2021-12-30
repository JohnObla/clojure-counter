(ns app.ui
 (:require
  [com.fulcrologic.fulcro.components :as compo :refer [defsc]]
  [com.fulcrologic.fulcro.dom :as dom]))

(defsc Counter [_ _]
  (dom/p "Counter"))

(def ui-counter (compo/factory Counter))

(defsc Root [_ _]
  (dom/div "ui-counter"))