/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imos.basicofjava.annotation;

/**
 *
 * @author INVCH018
 */
//@AutoService(Processor.class)
//public class FactoryProcessor extends AbstractProcessor {
//
//  private Types typeUtils;
//  private Elements elementUtils;
//  private Filer filer;
//  private Messager messager;
//  private Map<String, FactoryGroupedClasses> factoryClasses = new LinkedHashMap<String, FactoryGroupedClasses>();
//
//  @Override
//  public synchronized void init(ProcessingEnvironment processingEnv) {
//    super.init(processingEnv);
//    typeUtils = processingEnv.getTypeUtils();
//    elementUtils = processingEnv.getElementUtils();
//    filer = processingEnv.getFiler();
//    messager = processingEnv.getMessager();
//  }
//
//  @Override
//  public Set<String> getSupportedAnnotationTypes() {
//    Set<String> annotataions = new LinkedHashSet<String>();
//    annotataions.add(Factory.class.getCanonicalName());
//    return annotataions;
//  }
//
//  @Override
//  public SourceVersion getSupportedSourceVersion() {
//    return SourceVersion.latestSupported();
//  }
//
//  @Override
//  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
//      return true;
//  }
//
//}
