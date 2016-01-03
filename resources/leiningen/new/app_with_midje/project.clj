(defproject {{sanitized}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :main ^:skip-aot {{main}}
  :target-path "target/%s"
  :repl-options {:init-ns {{repl-ns}}}
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[midje "1.8.2"]]}})

