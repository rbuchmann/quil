(defproject quil "2.0.0-SNAPSHOT"
  :description "(mix Processing Clojure)"
  :url "http://github.com/quil/quil"

  :mailing-list {:name "Quil Mailing List"
                 :archive "https://groups.google.com/forum/?fromgroups#!forum/clj-processing"
                 :post "clj-processing@googlegroups.com"}

  :license {:name "Common Public License - v 1.0"
            :url "http://www.opensource.org/licenses/cpl1.0"}

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [quil/processing-core "2.2.0"]
                 [quil/processing-pdf "2.2.0"]
                 [quil/processing-dxf "2.2.0"]
                 [quil/jogl-all-fat "2.1.5"]
                 [quil/gluegen-rt-fat "2.1.5"]
                 [com.lowagie/itext "2.1.7"]
                 [org.clojure/clojurescript "0.0-2173"]]

  :plugins [[com.keminglabs/cljx "0.3.2"]
            [lein-cljsbuild "1.0.2"]]

  ;:hooks [cljx.hooks leiningen.cljsbuild]

  :aot [quil.helpers.applet-listener quil.applet]

  :profiles {:dev {:dependencies [[hiccup "1.0.5"]
                                  [garden "1.1.6"]]}}
  :test-selectors {:default (complement :manual)
                   :manual :manual}

  ;:prep-tasks ["javac" "compile"]
  ;:source-paths ["src" "target/classes" "target/classes/quil/helpers"]

  :cljx {:builds [{:source-paths ["src"]
                   :output-path "target/classes"
                   :rules :clj}
                  {:source-paths ["src"]
                   :output-path "src/gen/cljs"
                   :rules :cljs}]}

  :cljsbuild
  {:builds [{:source-paths ["src/cljs" "src/gen/cljs"]
             :compiler
             {:output-to "resources/js/main.js"
              :optimizations :whitespace
              :libs ["resources/js/processing.js"]
              :pretty-print true}}]})
