# android-databinding
Data Binding

Support from API level 11.

To enable :
  Add dataBinding.enabled=true in build.gradle in defaultConfig
  
Three ways:
    implements BaseObserver
    implements Observable
    user ObservableField
    
    BaseObserver: 
      Add @Bindable in getter
      and notifyChange(BR.<memberVariable>) in setter
      
    Observable
      Use PropertyChangeRegistry  object to notify
      
    ObservableField
      create ObservableField object
      Any set and put operation on observableField object will trigger notification to respective member variabe
