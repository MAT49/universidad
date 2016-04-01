require 'test_helper'

class TwosControllerTest < ActionController::TestCase
  setup do
    @two = twos(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:twos)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create two" do
    assert_difference('Two.count') do
      post :create, two: { first: @two.first, second: @two.second }
    end

    assert_redirected_to two_path(assigns(:two))
  end

  test "should show two" do
    get :show, id: @two
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @two
    assert_response :success
  end

  test "should update two" do
    patch :update, id: @two, two: { first: @two.first, second: @two.second }
    assert_redirected_to two_path(assigns(:two))
  end

  test "should destroy two" do
    assert_difference('Two.count', -1) do
      delete :destroy, id: @two
    end

    assert_redirected_to twos_path
  end
end
