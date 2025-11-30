public class MockNetworkAdapter implements INetworkConnection {
    @Override
    public boolean isConnected() {
        // Gerçek hayatta burası ping atardı.
        // Test için bazen true bazen false döndürebilirsin.
        return true;
    }
}