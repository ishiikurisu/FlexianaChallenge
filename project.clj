(defproject challenge "0.0.1"
    :description "Flexina Challenge"
    :url "https://github.com/ishiikurisu/FlexinaChallenge"
    :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
              :url "https://www.eclipse.org/legal/epl-2.0/"}
    :dependencies [[org.clojure/clojure "1.10.1"]
                   [org.clojure/clojurescript "1.10.758"]
                   [compojure "1.6.1"]
                   [http-kit "2.3.0"]
                   [ring/ring-defaults "0.3.2"]
                   [org.clojure/data.json "0.2.6"]
                   [selmer "1.12.40"]]
    :plugins [[lein-cljsbuild "1.1.8"]]
    :main ^:skip-aot challenge.core
    :target-path "target/%s"

    :resource-paths ["resources" "target/cljsbuild"]
    :cljsbuild
    {:builds
       {:app
        {:source-paths ["src/cljs"]
         :compiler
                       {:main          (str project-ns ".app")
                        :asset-path    "/js/out"
                        :output-to     "target/cljsbuild/public/js/app.js"
                        :output-dir    "target/cljsbuild/public/js/out"
                        :optimizations :none
                        :source-map    true
                        :pretty-print  true}}
        :min
        {:source-paths ["src/cljs"]
         :compiler
                       {:output-to     "target/cljsbuild/public/js/app.js"
                        :output-dir    "target/uberjar"
                        :externs       []
                        :optimizations :advanced
                        :pretty-print  false}}}}

    :profiles {:uberjar {:aot :all
                         :jvm-opts ["-Dclojure.compiler.direct-linking=true"]
                         :prep-tasks ["compile" ["cljsbuild" "once" "min"]]}}
)
